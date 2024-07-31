package dto;

/**@Getter*/
/**@ToString*/
/**@AllArgsConstructor*/
/**@NoArgsConstructor*/
class StudentReward1 {
    private String rewardType;
    private long rewardValue;
    private String voucherId;

    // RewardInfo 객체로부터 StudentReward 를 생성해주는 데 필요한 부생성자
    public StudentReward1(RewardInfo1 rewardInfo) {
        this.rewardType = rewardInfo.getType();
        this.rewardValue = rewardInfo.getValue();
        this.voucherId = (rewardInfo instanceof VoucherInfo1) ? ((VoucherInfo1) rewardInfo).getVoucherId() : null;
    }
}

// 보상 기본 정보를 제시하는 추상 클래스
abstract class RewardInfo1 {
    public abstract String getType();
    public abstract long getValue();
}

/**@Getter*/
/**@ToString*/
/**@AllArgsConstructor*/
/**@NoArgsConstructor*/
class VoucherInfo1 extends RewardInfo1 {
    private String voucherId;
    private long voucherValue;

    @Override
    public String getType() {
        return "Voucher";
    }

    @Override
    public long getValue() {
        return 0L;  // 실제 상품권의 가치는 다를 수 있습니다.
    }

    public String getVoucherId() {
        return this.voucherId;
    }
 }


/**@Getter*/
/**@ToString*/
/**@AllArgsConstructor*/
/**@NoArgsConstructor*/
class PointsInfo1 extends RewardInfo1 {
    private long points;

    @Override
    public String getType() {
        return "Points";
    }

    @Override
    public long getValue() {
        return points;
    }
}


public class DtoStudy2 {
    public static void main(String[] args) {
        // 상품권 보상 정보 객체 생성
        VoucherInfo voucherInfo = new VoucherInfo("voucher123", 5000L); // 실제 상품권의 가치를 5000으로 설정
        // 포인트 보상 정보 객체 생성
        PointsInfo pointsInfo = new PointsInfo(1000L);

        // StudentReward 객체 생성
        StudentReward studentRewardFromVoucher = new StudentReward(voucherInfo);
        StudentReward studentRewardFromPoints = new StudentReward(pointsInfo);

        // 생성된 StudentReward 객체 출력
        System.out.println("자바");
        System.out.println("StudentReward from VoucherInfo:");
        System.out.println("Reward Type: " + studentRewardFromVoucher.getRewardType());
        System.out.println("Reward Value: " + studentRewardFromVoucher.getRewardValue());
        System.out.println("Voucher ID: " + studentRewardFromVoucher.getVoucherId());

        System.out.println("\nStudentReward from PointsInfo:");
        System.out.println("Reward Type: " + studentRewardFromPoints.getRewardType());
        System.out.println("Reward Value: " + studentRewardFromPoints.getRewardValue());
        System.out.println("Voucher ID: " + studentRewardFromPoints.getVoucherId());
    }
}



