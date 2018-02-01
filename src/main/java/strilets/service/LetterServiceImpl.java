package strilets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import strilets.dao.LetterDao;
import strilets.model.Letter;

@Service("letterService")
@Transactional
public class LetterServiceImpl implements LetterService {

	@Autowired
	private LetterDao dao;

	public void saveLetter(Letter Letter) {
		dao.saveLetter(Letter);
	}

	public void deleteLetter(int id) {
		dao.deleteLetter(id);
	}

	public List<Letter> getLetters(String data) {
		List<Letter> letters = dao.getLetters(data);
		return letters;
	}

}
