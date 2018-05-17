package com.jiyongjun.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jiyongjun
 * @create 2018-05-17 21:54
 * @desc
 **/
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        List<Bean> fun = test.fun();
    }

    public List<Bean> fun() {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean("北京省", 1, null));
        list.add(new Bean("北京市", 2, 1));
        list.add(new Bean("朝阳区", 3, 2));
        list.add(new Bean("海淀区", 4, 2));
        list.add(new Bean("昌平区", 5, 2));

        for (Bean bean : list) {
            if (bean.getParentId() != null) {
                Bean parent = findParent(bean.getParentId(), list);
                if (parent != null) {
                    List<Bean> subList = parent.getSubList();
                    if (subList == null) {
                        subList = new ArrayList<>();
                        parent.setSubList(subList);
                    }
                    subList.add(bean);
                }
            }
        }
        Stream<Bean> stream = list.stream().filter((e) -> {
            return e.getParentId() == null;
        });
        return list;
    }

    private static Bean findParent(Integer parentId, List<Bean> list) {
        for (Bean bean : list) {
            if (bean.getId().equals(parentId)) {
                return bean;
            }
        }
        return null;
    }

    public class Bean {
        private String name;
        private Integer id;
        private Integer parentId;
        private List<Bean> subList;

        public Bean() {
        }

        public Bean(String name, Integer id, Integer parentId) {
            this.name = name;
            this.id = id;
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public List<Bean> getSubList() {
            return subList;
        }

        public void setSubList(List<Bean> subList) {
            this.subList = subList;
        }
    }
}
