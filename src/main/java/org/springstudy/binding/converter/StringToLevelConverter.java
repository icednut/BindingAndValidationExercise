package org.springstudy.binding.converter;

import org.springframework.core.convert.converter.Converter;
import org.springstudy.common.dto.Level;

/**
 * @author wangeun.lee@sk.com
 */
public class StringToLevelConverter implements Converter<String, Level> {
    @Override
    public Level convert(String text) {
        return Level.valueOf(Integer.parseInt(text));
    }
}
