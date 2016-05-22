# This_Is_Repository

# 5월 8일

Netty 76p 까지 완료!

temp 패키지 추가

EchoServer 자바 수정
BlockingEchoServer 자바 추가
EpollEchoServer 자바 추가 - 리눅스에서만 작동!

EventLoopGroup에 숫자는 최대 쓰레드를 의미

# 5월 14일

Netty 96p 까지 완료! (3장 까지)

EchoServerWithOption 자바 추가
EchoServerV4 자바 추가

ACK 패킷은 TCP 패킷 중 하나로 데이터 전송이 정상적으로 수신이 되었음을 알리는 패킷

네이글 알고리즘

'가능하면 데이터를 나누어 보내지 말고 한꺼번에 보내라'라는 원칙을 기반으로
만들어진 알고리즘으로 데이터를 여러 번에 나누어서 전송하면 각 패킷에 불필요한
50바이트의 헤더 정보로 인한 오버헤드가 발생하기 때문에 이를 방지하고자
데이터를 모아서 전송하라는 의도다.

# 5월 15일

Netty 111p 까지 완료!

handler 패키지 분리
EchoServerV1 추가
EchoServerV2 수정
EchoServerV1Handler 추가
EchoServerV2Handler 추가

채널 파이프라인 - 이벤트 핸들러를 나누는 구역!

# 5월 21일

Netty 181p 까지 완료! (Part2 완료)

HelloWorld 예제까지만 추가 

이후에는 소스 삭제 및 네티서버 구축

바이트버퍼 다시 복습할 것!

# 5월 22일

Netty 1독 완료

예제가 일부 deprecate 되었거나 에러가 나는 예제 Fix

바이트버퍼와 보안부분은 다시 학습할 것!
