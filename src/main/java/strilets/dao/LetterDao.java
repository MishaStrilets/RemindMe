package strilets.dao;

import java.util.List;

import strilets.model.Letter;

public interface LetterDao {

	void saveLetter(Letter Letter);

	void deleteLetter(int id);

	List<Letter> getLetters(String data);

}
