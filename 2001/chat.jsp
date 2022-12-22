 <%@ page import = "Client.*" %>
 <%@ page import = "ClientThread.*" %>

<!DOCTYPE html>
<html lang="en-us">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping list example</title>
    <style>
      li {
        margin-bottom: 10px;
      }
      span {
        margin-bottom: 10px;
        color: rgb(253, 8, 8);
        text-decoration: underline;
      }

      li button {
        font-size: 12px;
        margin-left: 20px;
        color: #666;
      }
    </style>
  </head>
  <body>

    <div>
      <label for="item">Enter a new item:</label>
      <input type="text" name="item" id="item">
      <button>Add item</button>
    </div>
    <ul>

    </ul>

 <% 
 <script>
  const list = document.querySelector('ul');
  const input = document.querySelector('input');
  const button = document.querySelector('button');

  button.addEventListener('click', () => {
    const myItem = input.value;
    input.value = '';

    const listItem = document.createElement('li');
    const listText = document.createElement('span');
    const listBtn = document.createElement('button');

    listItem.appendChild(listText);
    listText.textContent = myItem;
    listItem.appendChild(listBtn);
    listBtn.textContent = 'Delete';
    list.appendChild(listItem);

    listBtn.addEventListener('click', () => {
      list.removeChild(listItem);
    });

    input.focus();
  });
</script>
 %>
   
   
  </body>
</html>