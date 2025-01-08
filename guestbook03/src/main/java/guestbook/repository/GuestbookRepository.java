package guestbook.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import guestbook.repository.template.JdbcContext;
import guestbook.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	private JdbcContext jdbcContext;

	public GuestbookRepository(JdbcContext jdbcContext, DataSource dataSource) {
		this.jdbcContext = jdbcContext;
	}

	public List<GuestbookVo> findAll() {
		return jdbcContext.query(
				"select id, name, contents, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by reg_date desc",
				new BeanPropertyRowMapper<>(GuestbookVo.class));
	}

	public int insert(GuestbookVo vo) {
		return jdbcContext.update("insert into guestbook values(null, ?, ?, ?, now())",
				new Object[] { vo.getName(), vo.getPassword(), vo.getContents() });
	}

	public int deleteByIdAndPassword(long id, String password) {
		return jdbcContext.update("delete from guestbook where id = ? and password = ?",
				new Object[] { id, password });
	}

	public GuestbookVo findById(Long id) {
		return jdbcContext.queryForObject("select id, name, contents, date_format(reg_date, '%Y-%m-%d') as regDate from guestbook where id = ?", new Object[] {id}, new BeanPropertyRowMapper<>(GuestbookVo.class));
	}

}
