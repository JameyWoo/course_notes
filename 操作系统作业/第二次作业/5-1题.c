#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv) {

    int x = 100;
    printf("My pid: %d, x = %d\n", (int)getpid(), x);

    int child = fork();
}