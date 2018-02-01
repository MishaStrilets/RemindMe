package strilets.service;

import java.util.List;

import strilets.model.Letter;

public interface LetterService {

	void saveLetter(Letter letter);

	void deleteLetter(int id);

	List<Letter> getLetters(String data);

}
