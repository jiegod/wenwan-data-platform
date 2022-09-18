package com.wenwan.service.api.sort;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.SourceFileVo;
import com.wenwan.model.sort.TriggerSortVo;

public interface SortService {

    SearchResult<SourceFileVo> list(SourceFileVo sourceFileVo);

    void trigger(TriggerSortVo triggerSortVo);

    void autoTrigger(Integer operateDate);

}
