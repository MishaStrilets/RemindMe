package strilets.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import strilets.model.Letter;

@Repository("LetterDao")
public class LetterDaoImpl extends AbstrarctDao<Integer, Letter> implements LetterDao {

	static final Logger logger = LoggerFactory.getLogger(LetterDaoImpl.class);

	public void saveLetter(Letter letter) {
		logger.info("Save letter: {}", letter);
		persist(letter);
	}

	public void deleteLetter(int id) {
		logger.info("Delete letter by id: {}", id);
		Query query = getSession().createSQLQuery("delete from Letter where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Letter> getLetters(String data) {
		logger.info("Search letter by data: {}", data);

		Criteria criteria = createEntityCriteria();
		List<Letter> letters;

		criteria.add(Restrictions.like("date", data, MatchMode.START));
		letters = criteria.list();

		return letters;
	}

}
