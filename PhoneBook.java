package lesson_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
        private Map<String, List<String>> phoneBookHashMap = new HashMap<>();
        private List<String> phoneNumberList;

        public void add(String surname, String phoneNumber) {
            if (phoneBookHashMap.containsKey(surname)) {
                phoneNumberList = phoneBookHashMap.get(surname);
                phoneNumberList.add(phoneNumber);
                phoneBookHashMap.put(surname, phoneNumberList);
            } else {
                phoneNumberList = new ArrayList<>();
                phoneNumberList.add(phoneNumber);
                phoneBookHashMap.put(surname, phoneNumberList);
            }
        }

        public List<String> get(String surname) {
            return phoneBookHashMap.get(surname);
        }

}
