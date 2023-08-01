package com.chatGpt.controller;

import java.util.List;
import java.util.UUID;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatGpt.dto.GPTMessage;
import com.chatGpt.dto.ResponseImage;
import com.chatGpt.dto.ResponseModel;
import com.chatGpt.service.ChatgptService;
import com.chatGpt.service.DBService;
import com.chatGpt.service.SlackService;
import com.chatGpt.service.WAService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
public class GptController {

	@Autowired
	private ChatgptService chatgptService;

	@Autowired
	private WAService wAService;

	@Autowired
	private SlackService slackService;
	
	@Autowired
	private DBService dbs;
	
	@GetMapping("/image")
	public ResponseEntity<ResponseImage> getImage(@RequestParam(required =true) String message, @RequestParam(required = true) String conversationId, @RequestParam(required = true) String userId)  {
		
		 ResponseEntity<String> responseEntity = chatgptService.generateImage(message);
		 ResponseImage ri = new ResponseImage();
		 String res = responseEntity.getBody();
		 ri.setIntent("None");
		 ri.setMessage(res);
		 if (responseEntity.getStatusCode().is2xxSuccessful()) {
				String id = dbs.savingTransaction(ri, conversationId, message).getBody().getId();
				ri.setId(id);
			}
		return new ResponseEntity<ResponseImage>(ri, HttpStatus.OK);
	}
	
	
	@GetMapping("/send")
	public ResponseModel send(HttpServletRequest request, @RequestParam(required =true) String message) {
		String requestId = UUID.randomUUID().toString();
		log.info("requestId {}, ip {}, send a message : {}", requestId, request.getRemoteHost(), message);
		if (!StringUtils.hasText(message)) {
			return ResponseModel.fail("message can not be blank");
		}
		try {
			String responseMessage = chatgptService.sendMessage(message);
			log.info("Response--> requestId {}, ip {}, response : {}", requestId, request.getRemoteHost(),
					responseMessage);
			return ResponseModel.success(responseMessage);
		} catch (Exception e) {
			log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), e);
			return new ResponseModel(500, "error", e.getMessage());
		}
	}

	@PostMapping("/send")
	public ResponseModel sendArray(HttpServletRequest request, @RequestBody List<GPTMessage> message) {
		String requestId = UUID.randomUUID().toString();
		log.info("requestId {}, ip {}, send a message : {}", requestId, request.getRemoteHost(), message);
		if (!java.util.Objects.nonNull(message)) {
			return ResponseModel.fail("message can not be blank");
		}
		try {
			String responseMessage = chatgptService.sendMessage1(message);
			log.info("Response--> requestId {}, ip {}, response : {}", requestId, request.getRemoteHost(),
					responseMessage);
			return ResponseModel.success(responseMessage);
		} catch (Exception e) {
			log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), e);
			return new ResponseModel(500, "error", e.getMessage());
		}
	}

	
	
	@GetMapping("/sendSlack")
	public ResponseModel sendSlack(HttpServletRequest request, @RequestParam String message) {
		String requestId = UUID.randomUUID().toString();
		log.info("requestId {}, ip {}, send a message : {}", requestId, request.getRemoteHost(), message);
		if (!StringUtils.hasText(message)) {
			return ResponseModel.fail("message can not be blank");
		}
		try {
			String responseMessage = chatgptService.sendMessage(message);
			String msg = "";
			try {
				msg = slackService.sendMessageToSlack(responseMessage);
				responseMessage = responseMessage + "\n" + msg;
			} catch (Exception e) {
				responseMessage = responseMessage + "\n" + msg;

			}

			log.info("Response--> requestId {}, ip {}, response : {}", requestId, request.getRemoteHost(),
					responseMessage);
			return ResponseModel.success(responseMessage);
		} catch (Exception e) {
			log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), e);
			return new ResponseModel(500, "error", e.getMessage());
		}
	}

//	@GetMapping("/sendWolfram")
//	public ResponseModel send2wa(HttpServletRequest request, @RequestParam String message) {
//		String requestId = UUID.randomUUID().toString();
//		log.info("requestId {}, ip {}, send a message : {}", requestId, request.getRemoteHost(), message);
//		if (!StringUtils.hasText(message)) {
//			return ResponseModel.fail("message can not be blank");
//		}
//		try {
//			Object responseMessage = wAService.sendMessage(message);
//			log.info("Response--> requestId {}, ip {}, response : {}", requestId, request.getRemoteHost(),
//					responseMessage);
//			return ResponseModel.success(responseMessage);
//		} catch (Exception e) {
//			log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), e);
//			return new ResponseModel(500, "error", e.getMessage());
//		}
//	}

	
	@GetMapping("/sendWolfram")
	public ResponseModel send2wa(@RequestParam String message) {
		String requestId = UUID.randomUUID().toString();
		log.info("requestId {}, ip {}, send a message : {}", message);
		if (!StringUtils.hasText(message)) {
			return ResponseModel.fail("message can not be blank");
		}
		try {
			Object responseMessage = wAService.sendMessage(message);
			log.info("Response--> requestId {}, ip {}, response : {}", requestId,
					responseMessage);
			return ResponseModel.success(responseMessage);
		} catch (Exception e) {
			log.error("requestId {}, ip {}, error", requestId, e);
			return new ResponseModel(500, "error", e.getMessage());
		}
	}

}
