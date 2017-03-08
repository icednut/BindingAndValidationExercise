package org.springstudy.binding.binder;

import org.springstudy.common.dto.Level;

import java.beans.PropertyEditorSupport;

/**
 * @author wangeun.lee@sk.com
 */
public class LevelPropertyEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        return String.valueOf(((Level) this.getValue()).intValue());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        int value = Integer.parseInt(text.trim());
        Level level = Level.valueOf(value);
        this.setValue(level);
    }
}
