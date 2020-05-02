package com.thankson.common.util.pagehelper;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 *
 * @author Thankson
 * @date 2020年2月19日
 */
public class Page<T> implements Serializable {

    /**
     * 当前默认为第一页
     */
    public static final Integer pageNum = 1;

    /**
     * 默认每页显示条件
     */
    public static final Integer pageSize = 20;

    /**
     * 页数(页数)
     */
    private long currentPage;

    /**
     * 从数据库查处的总记录数
     */
    private long total;

    /**
     * 每页显示条数
     */
    private int size;

    /**
     * 下页
     */
    private int next;

    /**
     * 数据集合
     */
    private List<T> list;

    /**
     * 最后一页
     */
    private int last;

    /**
     * 上一页
     */
    private int leftPage;

    /**
     * 下一页
     */
    private int rightPage;

    /**
     * 开始条数
     */
    private long start;

    /**
     * 全局偏移量
     */
    public int offSize = 2;

    public Page() {
        super();
    }

    public Page(long total, int currentPage, int pageSize) {
        initPage(total, currentPage, pageSize);
    }

    /**
     * 初始化分页
     *
     * @param total       条数
     * @param currentPage 当前页数
     * @param pageSize
     */
    private void initPage(long total, int currentPage, int pageSize) {
        //总记录数
        this.total = total;
        //每页显示多少条
        this.size = pageSize;

        //计算当前页和数据库查询起始值以及总页数
        setCurrentPage(currentPage, total, pageSize);

        //分页计算
        int leftCount = this.offSize;
        //需要向上一页执行多少次
        int rightCount = this.offSize;

        //起点页
        this.leftPage = currentPage;
        //结束页
        this.rightPage = currentPage;

        //2点判断
        //正常情况下的起点
        this.leftPage = currentPage - leftCount;
        //正常情况下的终点
        this.rightPage = currentPage + rightCount;

        //页差=总页数和结束页的差
        //判断是否大于最大页数
        int topDiv = this.last - rightPage;
        /*
         * 起点页
         * 1、页差<0  起点页=起点页+页差值
         * 2、页差>=0 起点和终点判断
         */
        this.leftPage = topDiv < 0 ? this.leftPage + topDiv : this.leftPage;

        /*
         * 结束页
         * 1、起点页<=0   结束页=|起点页|+1
         * 2、起点页>0    结束页
         */
        this.rightPage = this.leftPage <= 0 ? this.rightPage + (this.leftPage * -1) + 1 : this.rightPage;

        /*
         * 当起点页<=0  让起点页为第一页
         * 否则不管
         */
        this.leftPage = this.leftPage <= 0 ? 1 : this.leftPage;

        /*
         * 如果结束页>总页数   结束页=总页数
         * 否则不管
         */
        //this.rightPage = this.rightPage > last ? this.last : this.rightPage;
        this.rightPage = Math.min(this.rightPage, last);
    }

    /**
     * 设定当前页
     *
     * @param currentPage 当前页数
     * @param total       条数
     * @param pageSize    显示数量
     */
    public void setCurrentPage(long currentPage, long total, long pageSize) {
        //可以整除的情况下
        long pageCount = total / pageSize;

        //如果整除表示正好分N页，如果不能整除在N页的基础上+1页
        int totalPages = (int) (total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1);

        //总页数
        this.last = totalPages;

        //判断当前页是否越界,如果越界，我们就查最后一页
        if (currentPage > totalPages) {
            this.currentPage = totalPages;
        } else {
            this.currentPage = currentPage;
        }

        //计算start
        this.start = (this.currentPage - 1) * pageSize;
    }

    /**
     * 判断当前页是否为空或是小于1
     *
     * @param pageNum 传入页数
     * @return 处理后的页数
     * @author Thankson
     * @date 2020年2月19日
     */
    public static Integer cpn(Integer pageNum) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        return pageNum;
    }

    /**
     * 获取上一页
     *
     * @return
     */
    public long getUpper() {
        return currentPage > 1 ? currentPage - 1 : currentPage;
    }

    /**
     * 获取最后一页
     *
     * @param last
     */
    public void setLast(int last) {
        this.last = (int) (total % size == 0 ? total / size : (total / size) + 1);
    }

    /**
     * 带有偏移量设置的分页
     *
     * @param total       条数
     * @param currentPage 当前页
     * @param pageSize    显示数量
     * @param offSize     偏移量
     */
    public Page(long total, int currentPage, int pageSize, int offSize) {
        this.offSize = offSize;
        initPage(total, currentPage, pageSize);
    }

    public long getNext() {
        return currentPage < last ? currentPage + 1 : last;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getLast() {
        return last;
    }

    public long getLeftPage() {
        return leftPage;
    }

    public void setLeftPage(int leftPage) {
        this.leftPage = leftPage;
    }

    public long getRightPage() {
        return rightPage;
    }

    public void setRightPage(int rightPage) {
        this.rightPage = rightPage;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        //总记录数
        //当前页
        //每页显示多少条
        //Page page = new Page(1001, cpage, 50, 7);
        Page page = new Page(100, 3, 10, 0);
        System.out.println("开始页:" + page.getLeftPage() + "__当前页：" + page.getCurrentPage() + "__结束页" + page.getRightPage() + "____总页数：" + page.getLast());
    }
}