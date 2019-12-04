package com.yydh.www.board;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory;
	private final String namespace = "BoardMapper";
	
	
	public BoardDAO() {
		InputStream inputStream = null;
		
		try {
			String resource = "mybatis-config.xml";
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	public List<BoardDTO> getBoardList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardDTO> lists = null;
		
		try {
			lists = session.selectList(namespace+".selectAll");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lists;
	}
	
	
	public BoardDTO getBoard(BoardDTO dto) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			dto = session.selectOne(namespace+".selectBoard",dto.getSeq());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return dto;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
