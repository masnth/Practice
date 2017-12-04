char firstNotRepeatingCharacter(String s) {
    if (s.length() == 1) 
        return s.charAt(0);
    else {
        while (!s.isEmpty()) {
            int preModLen = s.length();
            char currentChar = s.charAt(0);
            s = s.replaceAll(Character.toString(currentChar), "");
            if (preModLen - s.length() == 1)
                return currentChar;
        }
        System.out.println(s);
        return '_';
    }
    
}

