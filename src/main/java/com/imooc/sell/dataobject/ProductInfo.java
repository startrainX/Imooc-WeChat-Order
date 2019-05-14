package com.imooc.sell.dataobject;

import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @author ：zsp
 * @date ：Created in 2019/5/5 15:23
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 商品状态，0正常1下架 */
    private Integer productStatus = ProductStatusEnum.Up.getCode();

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    public ProductStatusEnum getProductStatus(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
