package strilets.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

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

	public List<Letter> getLetters(String date) {
		List<Letter> letters = dao.getLetters(date);
		return letters;
	}

	public void sendLetter() {
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatForDateNow.format(dateNow);

		System.out.println("%%%%%%% " + date);
		List<Letter> list = getLetters(date);

		// TODO send letter to email

		if (!list.isEmpty()) {
			for (Letter it : list)
				deleteLetter(it.getId());
		}

	}

}
