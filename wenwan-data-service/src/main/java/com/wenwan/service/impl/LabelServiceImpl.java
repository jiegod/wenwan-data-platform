package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.Label;
import com.wenwan.model.LabelQuery;
import com.wenwan.service.api.BaseService;
import com.wenwan.service.api.LabelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelServiceImpl extends BaseService implements LabelService {

    @Override
    public SearchResult<String> list(LabelQuery query) {
        LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery(Label.class)
                .eq(Label::getReceiver, query.getReceiver())
                .like(Label::getName, query.getName());

        List<Label> result = labelMapper.selectList(wrapper);
        return new SearchResult<>(result.stream().map(Label::getName).collect(Collectors.toList()), result.size());
    }
}
