$(function(){

    //セレクトボックス設定
    $('select').formSelect();

    //モーダルを開く
    $('.modal').modal();

    //データピッカーの設定
    $('.datepicker').datepicker({
        selectMonths: true,
        showClearBtn: true,
        autoClose: true,
        selectMonths: true,
        closeOnSelect: false,
        clear: 'Clear',
        format: 'yyyy/mm/dd'

    });

    $('#rem-memo-select').on('change', articleChange());

    $('#rem-memo-select-modal').on('change', articleChangeModal());


    //リマインダー／メモ変更で項目が変化する
    function articleChange()
     {

        $remmemo = $('#rem-memo-select').val();

        if ($remmemo == '001')
        {
            return $('.memo-no-disp').show();
        }
        else
        {
            return $('.memo-no-disp').hide();
        }
    }

    //リマインダー／メモ変更で項目が変化する（モーダル版）
    function articleChangeModal()
    {
        $remmemo = $('#rem-memo-select-modal').val();

        if ($remmemo == '001')
         {
            $('.memo-no-disp-modal').show();
        }
        else {
            $('.memo-no-disp-modal').hide();
        }
    }




});