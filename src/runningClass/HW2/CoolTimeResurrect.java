package runningClass.HW2;

public class CoolTimeResurrect implements Resurrectable {

    private long nextResurrectTime = 0;
    private final long coolTime;


    //고유 쿨타임을 가지게 하기
    public CoolTimeResurrect(long coolTime) {
        this.coolTime = coolTime;
    }


    //부활 가능한지
    //System.currentTimeMillis: 지금 시간을 밀리초 단위 long으로 리턴. 1000이 1초
    @Override
    public boolean canResurrect() {
        return System.currentTimeMillis() >= nextResurrectTime;
    }

    //부활 후 다음 부활 가능 시간 세팅
    @Override
    public void afterResurrect() {
        nextResurrectTime = System.currentTimeMillis() + coolTime;
    }
}
