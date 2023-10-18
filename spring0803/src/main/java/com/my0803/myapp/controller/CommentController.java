package com.my0803.myapp.controller;

import java.net.InetAddress;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my0803.myapp.domain.CommentVo;
import com.my0803.myapp.service.CommentService;

@RestController
@RequestMapping(value="/comment")
public class CommentController {
	
	@Autowired(required=false)
	private CommentService cs;
	
	
	
	@RequestMapping(value="/{bidx}/commentList.do")
	public JSONObject boardList(@PathVariable("bidx") int bidx) {
		
		JSONObject js = new JSONObject();
		ArrayList<CommentVo> list = cs.commentList(bidx);
		js.put("list", list);
		/*
		String str="";
		int cidx = 0;
		String cwriter = "";
		String ccontents = "";
		String cwriteday = "";
		int midx = 0;
		String comma = "";
			cidx=list.get(i).getCidx();
			cwriter=list.get(i).getCwriter();
			ccontents=list.get(i).getCcontents();
			cwriteday=list.get(i).getCwriteday();
			midx=list.get(i).getMidx();
			
			if (i == size - 1) {
				comma = "";
			} else {
				comma = ",";
			}
			
			str = str + "{\"cidx\":\"" + cidx + "\",\"cwriter\":\"" + cwriter + "\",\"ccontents\":\"" + ccontents
					+ "\",\"cwriteday\":\"" + cwriteday + "\",\"midx\":\"" + midx + "\"}" + comma ;
			
		}
		str = "[" + str + "]";
		*/
		
		return js;
	}
	
	@RequestMapping(value="/commentDelete.do", method=RequestMethod.POST)
	public JSONObject commentDelete(int cidx) {
		int value = cs.commentDelete(cidx);
		//String str= "{\"value\":\"" + value + "\"}";
		
		JSONObject js = new JSONObject();
		js.put("value", value);
		
		return js;
	}
	
	@RequestMapping(value="/commentWrite.do", method=RequestMethod.POST)
	public JSONObject commentWrite(CommentVo cv, HttpSession session) throws Exception {
		String ip = InetAddress.getLocalHost().getHostAddress();
		cv.setCip(ip);
		int value = cs.commentWrite(cv);
		//String str="{\"value\":\"" + value + "\"}";
		JSONObject js = new JSONObject();
		
		js.put("value", value);
		
		return js;

	}
}
