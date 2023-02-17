Instalar os módulos manualmente e gerar um Zip pra fazer upload pra AWS já contendo todos os módulos necessários, assim a imagem a ser utilizada pela Lambda já irá conter os módulos das quais dependo (no caso, o módulo requests). Para isso, vamos instalar e deixar os arquivos do módulo localmente com o comando:

python -m pip install requests -t .

Depois disso, vamos gerar o Zip com todas os módulos e também o códido lambda:

zip -r9 getClientDataBySSN .

