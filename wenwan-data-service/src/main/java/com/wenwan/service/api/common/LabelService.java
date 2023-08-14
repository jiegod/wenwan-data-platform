package com.wenwan.service.api.common;

import com.wenwan.mysql.dao.entity.Label;
import com.wenwan.model.sort.LabelVo;

import java.util.List;

public interface LabelService {

    List<LabelVo> labelList(LabelVo labelVo);

    List<Label> getAllLabel();
}
