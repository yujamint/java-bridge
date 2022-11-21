package bridge.controller;

import bridge.service.BridgeGenerateService;
import bridge.domain.GameCommand;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<String> bridge;

    private final BridgeGenerateService bridgeGenerateService;

    public BridgeGame(BridgeGenerateService bridgeGenerateService) {
        this.bridgeGenerateService = bridgeGenerateService;
    }

    private List<String> generateBridge(int size) {
        return bridgeGenerateService.generateBridgeBySize(size);
    }

    private boolean move(String moving, int position) {
        return bridge.get(position).equals(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean retry(String gameCommand) {
        return gameCommand.equals(GameCommand.RESTART.getCommand());
    }
}