package cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cms.backend.model.CstAddress;
import cms.frontend.model.JsonResponse;


@Controller
@RequestMapping("/Clipboard/**")
public class ClipboardController {
	
	@RequestMapping(value = "/Clipboard/GET", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody CstAddress getData(HttpSession session) {
		CstAddress testAdr = (CstAddress)session.getAttribute("Clipboard");
		return testAdr;
		
	}
	
	@RequestMapping(value = "/Clipboard/POST",method = RequestMethod.POST,produces = "application/json")
	public @ResponseBody
	JsonResponse addData(@RequestBody CstAddress address,HttpSession session)
	{
		JsonResponse resp = new JsonResponse();
		if(address != null){
			address.setCstAddress(0);
		    session.setAttribute("Clipboard", address);
		    resp.setStatus("OK");
		    resp.setResult("Kopeeritud");
		}
		else{
				resp.setStatus("ERROR");
				resp.setResult("tühi object");
		}		
		return resp;
	}
	
	@RequestMapping(value = "/Clipboard/CLEAR",method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody
	JsonResponse clearBoard(HttpSession session)
	{
		JsonResponse resp = new JsonResponse();
		CstAddress testAdr = (CstAddress)session.getAttribute("Clipboard");
		if(testAdr != null){
		    session.removeAttribute("Clipboard");
		    resp.setStatus("OK");
		    resp.setResult("Eemaldatud");
		}
		else{
				resp.setStatus("ERROR");
				resp.setResult("tühi object");
		}		
		return resp;
	}
	
	@RequestMapping(value = "/Clipboard/TEST", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody CstAddress getTestData(HttpSession session) {
		CstAddress testAdr = new CstAddress();
		testAdr.setAddress("testin sessiooni");
		session.setAttribute("Clipboard", testAdr);
		return testAdr;
		/*
		Enumeration<String> atb = session.getAttributeNames();
		do {
			String param = (String) atb.nextElement();
			System.out.println(session.getAttribute(param));	
		}
		while(atb.hasMoreElements());
         */
	}
}
