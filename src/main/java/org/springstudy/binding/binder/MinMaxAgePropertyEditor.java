package org.springstudy.binding.binder;

import java.beans.PropertyEditorSupport;

/**
 * @author wangeun.lee@sk.com
 */
public class MinMaxAgePropertyEditor extends PropertyEditorSupport {
    private int min;
    private int max;

    public MinMaxAgePropertyEditor(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String getAsText() {
        return String.valueOf((Integer) this.getValue());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        int val = Integer.parseInt(text);

        if (val < min) {
            val = min;
        } else if (val > max) {
            val = max;
        }
        setValue(val);
    }
}
