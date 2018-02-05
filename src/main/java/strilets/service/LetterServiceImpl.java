package strilets.service;

import java.text.SimpleDateFormat;
import java.util.List;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import strilets.dao.LetterDao;
import strilets.dao.LetterDaoImpl;
import strilets.model.Letter;

@Service("letterService")
@Transactional
public class LetterServiceImpl implements LetterService {

	static final Logger logger = LoggerFactory.getLogger(LetterDaoImpl.class);

	@Autowired
	private LetterDao dao;

	@Autowired
	public JavaMailSender emailSender;

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
		Date currenrDate = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatForDateNow.format(currenrDate);

		List<Letter> listLetter = getLetters(date);

		if (!listLetter.isEmpty()) {
			for (Letter letter : listLetter) {

				String text = letter.getDescription();
				String email = letter.getEmail();
				String[] receivers = email.split(";");

				for (String receiver : receivers) {

					try {
						SimpleMailMessage message = new SimpleMailMessage();
						message.setTo(receiver);
						message.setText(text);
						emailSender.send(message);
						logger.info("Send letter to email: {}", receiver);
					} catch (Exception e) {
						logger.info("Error sending letter to email: {}", receiver);
					}
				}
				deleteLetter(letter.getId());
			}
		}

	}

}
