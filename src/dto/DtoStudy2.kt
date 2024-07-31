package dto

// 학생이 교내 상을 받을 때의 보상을 처리하는 클래스 StudentReward 예시이며, 보상은 포인트 또는 상품권으로 제공될 수 있다.

data class StudentReward(
    /** 보상 유형: "Points" or "Voucher" */
    val rewardType: String,
    /** 보상 가치: 포인트일 경우 포인트 수, 상품권일 경우 상품권의 가치를 나타냄 */
    val rewardValue: Long,
    /** 상품권 ID: 보상이 상품권일 경우에만 존재하며 그 때 값은 "Voucher"이고, 포인트일 경우 null */
    val voucherId: String?,
) {
    // RewardInfo 객체로부터 StudentReward 를 생성해주는 데 필요한 부생성자
    constructor(rewardInfo: RewardInfo) : this(
        rewardType = rewardInfo.getType(),
        rewardValue = rewardInfo.getValue(),
        voucherId = when (rewardInfo) {
            is VoucherInfo -> rewardInfo.voucherId
            is PointsInfo -> null
            else -> null
        }
    )
}

// 보상 기본 정보를 제시하는 추상 클래스
abstract class RewardInfo {
    abstract fun getType(): String
    abstract fun getValue(): Long
}

// 상품권 보상 정보를 포함하는 클래스
class VoucherInfo(val voucherId: String, val voucherValue: Long) : RewardInfo() {
    override fun getType() = "Voucher"
    override fun getValue() = voucherValue
}

// 포인트 보상 정보를 포함하는 클래스
class PointsInfo(val points: Long) : RewardInfo() {
    override fun getType() = "Points"
    override fun getValue() = points
}

// 사용 예시
fun main() {
    // 상품권 보상 정보 객체 생성
    val voucherInfo = VoucherInfo("voucher123", 5000L) // 실제 상품권의 가치를 5000으로 설정
    // 포인트 보상 정보 객체 생성
    val pointsInfo = PointsInfo(1000L)

    // StudentReward 객체 생성
    val studentRewardFromVoucher = StudentReward(voucherInfo)
    val studentRewardFromPoints = StudentReward(pointsInfo)

    // 생성된 StudentReward 객체 출력
    println("코틀린")
    println("StudentReward from VoucherInfo:")
    println("Reward Type: ${studentRewardFromVoucher.rewardType}")
    println("Reward Value: ${studentRewardFromVoucher.rewardValue}")
    println("Voucher ID: ${studentRewardFromVoucher.voucherId}")

    println("\nStudentReward from PointsInfo:")
    println("Reward Type: ${studentRewardFromPoints.rewardType}")
    println("Reward Value: ${studentRewardFromPoints.rewardValue}")
    println("Voucher ID: ${studentRewardFromPoints.voucherId}")
}