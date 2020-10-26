package com.jiseung.s4.board.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiseung.s4.util.Pager;

@Repository
public class MemoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.jiseung.s4.board.memo.MemoDAO.";
	
	public List<MemoDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(namespace+"getList", pager);
	}
	
	public long getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(namespace+"getCount", pager);
	}
	
	public int setInsert(MemoDTO memoDTO) throws Exception{
		return sqlSession.insert(namespace+"setInsert", memoDTO);
	}
	
	public MemoDTO getOne(MemoDTO memoDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getOne", memoDTO);
	}
	
	public int setDelete(MemoDTO memoDTO) throws Exception{
		return sqlSession.delete(namespace+"setDelete", memoDTO);
	}

}
