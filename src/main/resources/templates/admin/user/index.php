<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="admin/fragments/head::head"></head>
<body>
    <div th:replace="admin/fragments/header::header"></div>
    <div class="user">
        <h2 id="title">Danh sách khách hàng</h2>
        <div class="control">
            <button id="btn-open">Thêm</button>
            <div>
                <form action="index.php?controller=user&action=search" method="post">
                    <input type="search" name="input-search" placeholder="Nhập mã, tên, sdt, email khách hàng" autocomplete="off" required>
                    <button type="submit" name="btn-search">Tìm</button>
                </form>
            </div>
        </div>

        <div class="main">
            <table>
                <thead>
                    <th>STT</th>
                    <th>Mã khách hàng</th>
                    <th>Tên khách hàng</th>
                    <th>Số điện thoại</th>
                    <th>Email</th>
                    <th>Thao tác</th>
                </thead>
                <tbody>
                    <?php 
                        $stt = 1;
                        foreach($users as $value):?>
                            <tr>
                                <td><?=$stt++?></td>
                                <td><?=$value->MaKH?></td>
                                <td><?=$value->TenKH?></td>
                                <td><?=$value->SDT?></td>
                                <td><?=$value->Email?></td>
                                <td>
                                    <a href="index.php?controller=user&action=show&iduser=<?=$value->MaKH?>&idaccount=<?=$value->MaTK?>&code2=3"><button id="btn-update" name="btn-update">Sửa</button></a>
                                    <button type="button" id="btn-delete" style="color: red;" onclick="actionDelete(<?=$value->MaTK?>, <?=$value->MaKH?>)">Xóa</button></a>
                                </td>
                            </tr>
                    <?php endforeach;?>
                </tbody>
            </table>
        </div>

        <div class="form-input" id="form-insert">
            <div class="content">
                <h2>Thêm khách hàng</h2>
                <button type="button" id="btn-close">X</button>
                <form action="index.php?controller=user&action=insert" method="post">
                    <label for="name">Tên khách hàng</label>
                    <input type="text" name="full-name" id="name" value="<?=isset($_REQUEST['full-name']) ? $_REQUEST['full-name'] : ''?>" required/> 
                    <label for="phone">Số điện thoại</label>
                    <input type="tel" name="number-phone" id="phone" pattern="[0-9]{10}" value="<?=isset($_REQUEST['number-phone']) ? $_REQUEST['number-phone'] : ''?>" required/>
                    <label for="email">Email</label>
                    <input type="text" name="email" id="email" value="<?=isset($_REQUEST['email']) ? $_REQUEST['email'] : ''?>" required/>
                    <label for="password">Mật khẩu</label>
                    <input type="password" name="password" id="password" value="<?=isset($_REQUEST['password']) ? $_REQUEST['password'] : ''?>" required/>
            
                    <button type="submit" name="btn-submit" id="btn-submit">Thêm</button>
                </form>
            </div>
        </div>

        <div class="form-input" id="form-update">
            <div class="content">
                <h2>Sửa thông tin khách hàng</h2>
                <button type="button" id="btn-close-update">X</button>
                <form action="index.php?controller=user&action=update" method="post">
                    <input type="hidden" name="iduser" value="<?=$_REQUEST['iduser'] ?? ''?>"/>        
                    <input type="hidden" name="idaccount" value="<?=$_REQUEST['idaccount'] ?? ''?>"/>

                    <label for="name">Tên khách hàng</label>
                    <input type="text" name="full-name" id="name" value="<?=$_REQUEST['full-name2'] ?? ''?>" required/> 
                    <label for="phone">Số điện thoại</label>
                    <input type="tel" name="number-phone" id="phone" pattern="[0-9]{9,10}" value="<?=$_REQUEST['number-phone2'] ?? ''?>" required/>
                    <label for="email">Email</label>
                    <input type="text" name="email" id="email" value="<?=$_REQUEST['email2'] ?? ''?>" required/>
                    <label for="password">Mật khẩu</label>
                    <input type="password" name="password" id="password" value="<?=$_REQUEST['password2'] ?? ''?>"/>
            
                    <button type="submit" name="btn-update" id="btn-submit">Cập nhật</button>
                </form>
            </div>
        </div>
    </div>

    <script>
        function actionDelete(idAccount, idUser) {
            Swal.fire({
                title: 'Xác nhận',
                html: `Bạn có chắc chắn xóa khách hàng <b>${idUser}</b> không?`,
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Có',
                cancelButtonText: 'Không'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = `index.php?controller=user&action=delete&iduser=${idUser}&idaccount=${idAccount}&code2=3`;
                }
            });
        }
    </script>

    <footer th:replace="admin/fragments/footer::footer"></footer>
</body>
</html>