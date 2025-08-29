package pokestats;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberDocumentFilter extends DocumentFilter {
    private final int min;
    private final int max;

    public NumberDocumentFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (isValid(fb, offset, string, 0)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (isValid(fb, offset, text, length)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isValid(FilterBypass fb, int offset, String string, int length) {
        try {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());

            String newText = currentText.substring(0, offset) + string + currentText.substring(offset + length);

            if (newText.isEmpty()) {
                return true;
            }

            int value = Integer.parseInt(newText);
            return value >= min && value <= max;

        } catch (NumberFormatException | BadLocationException e) {
            return false;
        }
    }
}