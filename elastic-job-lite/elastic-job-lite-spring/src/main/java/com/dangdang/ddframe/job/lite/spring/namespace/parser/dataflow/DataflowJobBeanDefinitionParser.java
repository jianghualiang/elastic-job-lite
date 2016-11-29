/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.lite.spring.namespace.parser.dataflow;

import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.namespace.parser.common.AbstractJobBeanDefinitionParser;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.w3c.dom.Element;

import static com.dangdang.ddframe.job.lite.spring.namespace.parser.common.BaseJobBeanDefinitionParserTag.CLASS_ATTRIBUTE;
import static com.dangdang.ddframe.job.lite.spring.namespace.parser.dataflow.DataflowJobBeanDefinitionParserTag.STREAMING_PROCESS_ATTRIBUTE;

/**
 * 数据流作业的命名空间解析器.
 * 
 * @author caohao
 */
public final class DataflowJobBeanDefinitionParser extends AbstractJobBeanDefinitionParser {
    
    @Override
    protected BeanDefinition getJobTypeConfigurationBeanDefinition(final BeanDefinition jobCoreConfigurationBeanDefinition, final Element element) {
        BeanDefinitionBuilder result = BeanDefinitionBuilder.rootBeanDefinition(DataflowJobConfiguration.class);
        result.addConstructorArgValue(jobCoreConfigurationBeanDefinition);
        result.addConstructorArgValue(element.getAttribute(CLASS_ATTRIBUTE));
        result.addConstructorArgValue(element.getAttribute(STREAMING_PROCESS_ATTRIBUTE));
        return result.getBeanDefinition();
    }
}
