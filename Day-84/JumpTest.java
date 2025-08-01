public class JumpTest {

    // Example 1:

    // Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    // Output: 3
    // Explanation:
    // Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 +
    // 4 = 4
    // Travel to station 4. Your tank = 4 - 1 + 5 = 8
    // Travel to station 0. Your tank = 8 - 2 + 1 = 7
    // Travel to station 1. Your tank = 7 - 3 + 2 = 6
    // Travel to station 2. Your tank = 6 - 4 + 3 = 5
    // Travel to station 3. The cost is 5. Your gas is just enough to travel back to
    // station 3.
    // Therefore, return 3 as the starting index.
    // Example 2:

    // Input: gas = [2,3,4], cost = [3,4,3]
    // Output: -1
    // Explanation:
    // You can't start at station 0 or 1, as there is not enough gas to travel to
    // the next station.
    // Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 =
    // 4
    // Travel to station 0. Your tank = 4 - 3 + 2 = 3
    // Travel to station 1. Your tank = 3 - 3 + 3 = 3
    // You cannot travel back to station 2, as it requires 4 unit of gas but you
    // only have 3.
    // Therefore, you can't travel around the circuit once no matter where you
    // start.
    public static void main(String[] args) {

        int gas[] = { 1, 2, 3, 4, 5 }, cost[] = { 3, 4, 5, 1, 2 };

        int result = canCompleteCircuit(gas, cost);

        System.out.println(result);

    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalCost = 0, totalGas = 0, currentGas = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {

                start = i + 1;
                currentGas = 0;

            }
        }

        return (totalGas >= totalCost) ? start : -1;
    }

}
