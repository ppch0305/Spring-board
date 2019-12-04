package com.yydh.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yydh.www.board.BoardDAO;
import com.yydh.www.board.BoardDTO;

@Controller
public class BoardController {

	@Autowired
	BoardDAO dao;
	
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDTO dto, Model model) {
		model.addAttribute("boardList",dao.getBoardList());
		return "getBoardList";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDTO dto, Model model) {
		model.addAttribute("board", dao.getBoard(dto));
		return "getBoard";
	}
	
	
	
	
	
	
	
	
	
}
