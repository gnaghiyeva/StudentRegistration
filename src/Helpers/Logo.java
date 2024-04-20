package Helpers;

import static Helpers.Colors.ANSI_BLUE;
import static Helpers.Colors.ANSI_RESET;

public class Logo {
    public static String WriteTextWithLetters(String universityName) {


        String[] logo = {
                "                                                   &&                                                            &                                          &                           &   ",
                "  &&&&&      &&     &    &   &&&&&        &&&&&   &&&&  &     &    &      &&&&&  &&&&&     &    &     &     &    &    &     &  &&&&&  &&&&&      &&&&&      &    &&&&&  &&&&&  &&&&&    &",
                "  &    &    &  &    &   &      &         &    &  &    &  &   &     &          &    &       &    &     & &   &    &     &   &   &      &    &    &           &      &    &        &      & ",
                "  &&&&&     &&&&&   &&&&       &         &    &  &    &   & &      &      & & &    &       &    &     &  &  &    &      & &    &&&&   &&&&&      &&&&&      &      &    &&&&&    &      & ",
                "  &    &   &    &   &   &      &         &    &  &    &    &       &      &   &    &       &    &     &   & &    &       &     &      &    &          &     &      &    &        &      &",
                "  &&&&&    &    &   &    &   &&&&&       &&&&&    &&&&     &       &&&&&  &&&&&    &       &&&&&&     &     &    &       &     &&&&&  &     &    &&&&&      &      &    &&&&&    &      &"
        };

        for (String line : logo) {
            System.out.println(ANSI_BLUE+line+ANSI_RESET);
        }
        return universityName;
    }
}
