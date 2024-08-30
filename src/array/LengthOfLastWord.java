package array;

import javax.print.DocFlavor;

/*
Учитывая строку, s состоящую из слов и пробелов, верните длину последнего слова в строке.

Слово - это максимальное
подстрока
 состоит только из символов, не содержащих пробелов.



Пример 1:

Ввод: s = "Привет, мир"
Вывод:5
Пояснение: Последнее слово - "Мир" длиной 5.
Пример 2:

Ввод: s = " отправь меня на Луну "
Вывод:4
Пояснение: Последнее слово - "луна" длиной 4.
Пример 3:

Ввод: s = "луффи по-прежнему джойбой"
Вывод:6
Пояснение: Последнее слово - "joyboy" длиной 6.


Ограничения:

1 <= s.length <= 104
s состоит только из английских букв и пробелов ' '.
В s должно быть как минимум одно слово.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] strings = s.trim().split("\\s+");
        return strings[strings.length - 1].length();
    }
}