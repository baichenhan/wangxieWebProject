<?php
    header('Content-Type:application/json');
    $array = [
            'id'           => 1,
            'role'     => '管理员'
    ];

    echo json_encode($array);
