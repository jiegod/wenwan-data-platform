package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.dao.entity.Label;
import com.wenwan.model.sort.LabelVo;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.common.LabelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelServiceImpl extends MapperConfigService<Label, LabelVo> implements LabelService{


    @Override
    public List<LabelVo> labelList(LabelVo labelVo) {
        List<LabelVo> result = new ArrayList<>();
        LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery(Label.class)
                .like(Label::getName, labelVo.getName());
        if (StringUtils.isNotEmpty(labelVo.getReceiver())) {
            wrapper.eq(Label::getReceiver, labelVo.getReceiver());
        }
        List<Label> labels = labelMapper.selectList(wrapper);
        labels.forEach(label -> {
            LabelVo labelVo1 = new LabelVo();
            BeanUtils.copyProperties(label, labelVo1);
            result.add(labelVo1);
        });
        return result;
    }

    @Override
    public List<Label> getAllLabel() {
        LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery(Label.class);
        List<Label> labels = labelMapper.selectList(wrapper);
        return labels;
    }
}
