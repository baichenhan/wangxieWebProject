<?php
    header('Content-Type:application/json');
    $array = [
        'id'            => 1,
        'rule'       => 'admin/add2',
        'name'            => '管理员人员添加',
        'cate'          => 3
    ];

    echo json_encode($array);
