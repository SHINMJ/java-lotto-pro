package lottoLegacy;

import static lottoLegacy.common.Constants.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lottoLegacy.common.Messages;

public class LottoInput {
	private List<LottoNumber> lottoNumbers;

	public LottoInput(String input) {
		validate(input);
		this.lottoNumbers =
			Arrays.stream(input.split(DELIMITER))
				.mapToInt(Integer::parseInt).mapToObj(LottoNumber::new)
				.collect(Collectors.toList());
	}

	/**
	 * validate 목록
	 * 1. 숫자와 , 만 입력 가능
	 * 2. 6개를 입력 해야 한다.
	 * 3. 1~45까지의 숫자만 입력 가능
	 * 4. 중복 숫자 허용하지 않는다.
	 *
	 * @param input
	 */
	private void validate(String input) {
		if (!NUMBER_COMMA_PATTERN.matcher(input).matches()) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_COMMA_FORMAT_NOT_VALID.getValues());
		}
		validString(input.split(DELIMITER));
	}

	private void validString(String[] split) {
		isLottoVolume(split);
		for (String s : split) {
			isNumber(s);
		}
		isDuplicate(split);
	}

	private void isNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_COMMA_FORMAT_NOT_VALID.getValues());
		}
	}

	private void isLottoVolume(String[] splitInput) {
		if (splitInput.length != VOLUME) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_LENGTH_NOT_VALID.getValues());
		}
	}

	private void isDuplicate(String[] splitInput) {
		Set<String> sets = new HashSet<>(Arrays.asList(splitInput));
		if (sets.size() != VOLUME) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_DUPLICATE.getValues());
		}
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

}