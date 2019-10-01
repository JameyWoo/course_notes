#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <string.h>
#include <unistd.h>

int main() {
    printf("My pid: %d\n", (int)getpid());
    int child = fork();
    if (child < 0) {
        printf("fork error !\n");
    } else if (child == 0) {
        printf("child pid: %d\n", (int)getpid());

        // execl("/bin/ls", "ls", NULL);

        // char const *envpath[] = {"PATH=/bin", "AA=/usr", NULL};
        // execle("/bin/ls", "ls", NULL, envpath);

        // execlp("/bin/ls", "ls", NULL);
        // execlp("ls", "ls", NULL);

        char *myargs[2];
        myargs[0] = strdup("ls");
        myargs[1] = NULL;
        execvp("ls", myargs);

        printf("never printf\n");
    }
}