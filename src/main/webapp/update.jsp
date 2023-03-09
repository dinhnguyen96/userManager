
<html>
<head>
    <title>Cập nhật thông tin</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<form>
  <input type="hidden" class="form-control" id="id" value="${id}">
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" id="name" placeholder="name" value="${name}">
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" placeholder="email" value="${email}">
  </div>
  <div class="form-group">
    <label for="country">Country</label>
    <input type="text" class="form-control" value="${country}" id="country" name="country" placeholder="country">
  </div>
</form>
</body>
</html>
