package cn.zh.proxy;

public interface IProducer {
    /**
     * 销售
     * @param money
     */
    void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    void afterService(float money);
}
