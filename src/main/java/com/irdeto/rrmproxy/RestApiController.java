package com.irdeto.rrmproxy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.collections4.ListUtils;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irdeto.rrmproxy.pojo.Authorization;
import com.irdeto.rrmproxy.pojo.AuthorizationList;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@PostMapping(value = "/authorize/")
	public ResponseEntity<String> authorize(@RequestBody AuthorizationList superList,
			@RequestHeader(value = "man-user-id") String username,
			@RequestHeader(value = "man-user-password") String password) {

		List<Authorization> authList = superList.getAuthorization();
		int max = 3;
		boolean res = false;
		int partition = (int) Math.ceil((authList.size() / max));
		try {
			if (partition > 1) {
				List<List<Authorization>> listOfList = ListUtils.partition(authList, partition);

				for (List<Authorization> authorization : listOfList) {
					AuthorizationList list = new AuthorizationList();
					list.setVersion(superList.getVersion());
					list.setAuthorization(authorization);
					if(Utility.response(username, password, list)) 
						res = true;
					else {
						res = false;
						break;
					}
				}
			} else if (authList.size() == 1) {
				res = Utility.response(username, password, superList);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  res ? new ResponseEntity<String>("OK", HttpStatus.OK) : new ResponseEntity<String>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
