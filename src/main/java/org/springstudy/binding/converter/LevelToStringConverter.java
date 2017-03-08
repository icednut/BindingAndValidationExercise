package org.springstudy.binding.converter;

import org.springframework.core.convert.converter.Converter;
import org.springstudy.common.dto.Level;

/**
 * @author wangeun.lee@sk.com
 */
public class LevelToStringConverter implements Converter<Level, String> {
    @Override
    public String convert(Level level) {
        return String.valueOf(level.intValue());
    }
}
