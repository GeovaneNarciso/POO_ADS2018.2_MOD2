from git_modelos import *

def main():
    opcao = - 1
    while opcao != 0:
        print("\n\n\n"
                  "-------------\n"
                  "|     G  git    |\n"
                  "-------------\n\n"
                  "Opções:\n"
                  "1 - Criar repositório\n"
                  "2 - Criar arquivo\n"
                  "0 - Sair\n")
        opcao = int(input("Informe a opção: "))
        if opcao == 1:
            nome_repo = input("Informe o nome do repositório: \n")
            repo_01 = Repositorio(nome_repo)
        elif opcao == 2:
            nome_arq = input("Informe o nome do arquivo: ")
            conteudo_arq = input("Informe o conteudo do arquivo: ")
            print(repo_01.criar_arquivo)
        elif opcao == 0:
            print("Encerrado.")

if __name__ == '__main__':
    main()
