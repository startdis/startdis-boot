package com.startdis.comm.jdbc.handler;

import com.startdis.comm.jdbc.config.FieldFillConfig;
import com.startdis.comm.jdbc.enums.FieldFillStrategyEnum;
import com.startdis.comm.kits.auth.AuthInfo;
import com.startdis.comm.kits.auth.AuthInfoUtils;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

import java.util.Optional;

/**
 * @author Startdis
 * @email startdis@yundingshuzi.cn
 * @desc 创建人字段填充拦截器
 */
public class CreatedByHandler extends AbstractFieldFillHandler {


    public CreatedByHandler(FieldFillConfig fieldFillConfig) {
        super(FieldFillStrategyEnum.INSERT, fieldFillConfig.getCreatedByIntercept());
    }


    @Override
    protected Expression doGetFieldFillValue() {
        AuthInfo authInfo = AuthInfoUtils.getAuthInfo();
        String uniqueId =  Optional.ofNullable(authInfo)
            .map(AuthInfo::getUniqueId).orElse("系统创建");
        return new StringValue(uniqueId);
    }

    @Override
    protected String getDefaultColumn() {
        return "created_by";
    }

}
