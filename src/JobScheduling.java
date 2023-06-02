import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobScheduling {

    public static void main(String[] args) {
        // 입력값 선언, 작업 리스트 L
        int[][] L = {{7, 8}, {3, 7}, {1, 5}, {5, 9}, {0, 2}, {6, 8}, {1, 6}};

        // 입력값 출력
        System.out.print("주어진 작업리스트 L: ");
        for (int i = 0; i < L.length; i++) {
            String a = Arrays.toString(L[i]);
            System.out.printf(a + " ");
        }


        // sorted_L : 정렬된 작업리스트 L
        List<int[]> sorted_L = new ArrayList<>(Arrays.asList(L));
        Collections.sort(sorted_L, (a, b) -> a[0] - b[0]);

        System.out.print("\n정렬된 작업리스트 L: ");
        for (int i = 0; i < sorted_L.size(); i++) {
            String a = Arrays.toString(sorted_L.get(i));

            System.out.printf(a + " ");
        }
        System.out.println("\n");

        // 작업을 저장할 기계 리스트 초기화
        List<List<int[]>> machines = new ArrayList<>();

        // 작업 스케줄링 알고리즘 job_algorim 호출
        List<List<int[]>> job = job_algoritm(sorted_L, machines);

        // 리턴받은 작업 순서대로 출력
        System.out.println("각 기계에 배정된 작업 순서대로 출력:");
        for (int i = 0; i < job.size(); i++) {
            List<int[]> machine = job.get(i);
            System.out.print("기계" + (i + 1) + ": ");
            for (int[] t : machine) {
                System.out.print(Arrays.toString(t) + " ");
            }
            System.out.println();
        }
    }




    // 작업 스케줄링 알고리즘 job_algorim
    public static List<List<int[]>> job_algoritm(List<int[]> sorted_L, List<List<int[]>> machines) {
        while (!sorted_L.isEmpty()) {
            int[] task = sorted_L.remove(0);
            int machine_index = -1;

            // 작업을 배정할 수 있는 기계 찾기
            for (int i = 0; i < machines.size(); i++) {
                List<int[]> machine = machines.get(i);

                int[] lastjob_in_machine = machine.get(machine.size() - 1);
                if (lastjob_in_machine[1] <= task[0]) { // 현재 기계에서 마지막작업이 현재 작업보다 먼저 끝난 경우
                    machine_index = i; // 작업을 배정할 기계의 인덱스를 설정.
                    break;
                }
            }

            // 작업을 수행할 기계가 있다면, 해당 기계에 배정한다.
            if (machine_index != -1) {
                machines.get(machine_index).add(task);
            }
            // 작업을 수행할 기계가 없다면 새로운 기계를 만든다.
            else {
                machines.add(new ArrayList<>(Arrays.asList(task)));
            }
        }
        return machines;
    }
}
