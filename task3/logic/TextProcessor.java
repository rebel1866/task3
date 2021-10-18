package by.epamtc.stanislavmelnikov.task3.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {
    private final String SPACE = " ";

    /* В каждом слове k-ю букву заменить заданным символом. Если k больше длины слова,
        корректировку не выполнять */
    public String replaceByIndex(String text, int index, String replacement) {
        String[] textArray = splitBySpace(text);
        StringBuilder targetText = new StringBuilder();
        for (String element : textArray) {
            StringBuilder word = new StringBuilder(element);
            if (index < word.length()) {
                word.replace(index, index + 1, replacement);
            }
            targetText.append(word + SPACE);
        }
        return targetText.toString();
    }

    /* В тексте после буквы Р, если она не последняя в слове, ошибочно напечатана буква А
     вместо О. Внести исправления в текст*/
    public String replaceByPattern(String text, String pattern, String replacement) {
        String[] textArray = splitBySpace(text);
        StringBuilder targetText = new StringBuilder();
        for (String word : textArray) {
            word = word.replaceAll(pattern, replacement);
            targetText.append(word + SPACE);
        }
        return targetText.toString();
    }

    /* Версия решения задачи с использованием регулярных выражений.
         В тексте после буквы Р, если она не последняя в слове, ошибочно напечатана буква А
         вместо О. Внести исправления в текст*/
    public String replaceByPatternRegex(String text, String pattern, String replacement) {
        StringBuilder targetText = new StringBuilder(text);
        Pattern template = Pattern.compile(pattern);
        Matcher matcher = template.matcher(targetText);
        while (matcher.find()) {
            targetText.replace(matcher.start(), matcher.end(), replacement);
        }
        return targetText.toString();
    }

    /* В тексте слова заданной длины заменить указанной подстрокой, длина которой может
    не совпадать с длиной слова. */
    public String replaceByLength(String text, int length, String replacement) {
        String[] arrayText = splitBySpace(text);
        StringBuilder targetText = new StringBuilder();
        for (String word : arrayText) {
            if (word.length() == length) {
                targetText.append(replacement);
            } else {
                targetText.append(word);
            }
            targetText.append(SPACE);
        }
        return targetText.toString();
    }

    /* Версия решения задачи с использованием регулярных выражений.
     В тексте слова заданной длины заменить указанной подстрокой, длина которой может
        не совпадать с длиной слова. */
    public String replaceByLengthRegex(String text, int length, String replacement) {
        String[] arrayText = splitBySpace(text);
        StringBuilder targetText = new StringBuilder();
        Pattern pattern = Pattern.compile("\\b[А-Яа-яA-Za-z]{" + length + "}\\b");
        for (String word : arrayText) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                targetText.append(replacement);
            } else {
                targetText.append(word);
            }
            targetText.append(SPACE);
        }
        return targetText.toString();
    }

    /* Версия решения с использованием метода класса String.
     Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
              Между последовательностями подряд идущих букв оставить хотя бы один пробел. */
    public String removeNonLetters(String text) {
        String targetText = text.replaceAll("[^A-Za-zА-Яа-я ]", SPACE);
        return targetText;
    }

    /* Версия решения с использованием методов классов Pattern и Matcher.
    Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
         Между последовательностями подряд идущих букв оставить хотя бы один пробел. */
    public String removeNonLettersRegex(String text) {
        StringBuilder targetText = new StringBuilder(text);
        Pattern pattern = Pattern.compile("[^A-Za-zА-Яа-я ]");
        Matcher matcher = pattern.matcher(targetText);
        while (matcher.find()) {
            targetText.replace(matcher.start(), matcher.end(), SPACE);
        }
        return targetText.toString();
    }

    /* Из текста удалить все слова заданной длины, начинающиеся на согласную букву */
    public String removeConsonantLength(String text, int length) {
        StringBuilder targetText = new StringBuilder(text);
        Pattern pattern = Pattern.compile("\\b[йцкнгшщзхждлрпвфчсмтб].{" + --length + "}\\b");
        Matcher matcher = pattern.matcher(targetText);
        while (matcher.find()) {
            targetText.delete(matcher.start(), matcher.end());
            matcher.reset(targetText);
        }
        String result = targetText.toString().replaceAll(" +", SPACE);
        return result;
    }

    public String[] splitBySpace(String text) {
        return text.split(SPACE);
    }
}