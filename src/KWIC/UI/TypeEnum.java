package KWIC.UI;

/**
 * @ClassName : TypeEnum  //类名
 * @Description : 种类枚举  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/10/14  20:46
 */
public enum TypeEnum {

    /**
     *
     */
    ONE_TYPE("主系统-子系统",0),
    TOW_TYPE("面对对象",1),
    THERE_TYPE ("事件系统和管道",2),
    FOURTH_TYPE("管道",3);

    private Integer type;

    private String message;

    TypeEnum(String message,Integer type) {
        this.type = type;
        this.message = message;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
